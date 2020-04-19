package com.bam.bs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bam.bs.dto.BillDto;
import com.bam.bs.dto.BillRequest;
import com.bam.bs.dto.SearchBillResponse;
import com.bam.bs.exception.CommonException;
import com.bam.bs.model.Bill;
import com.bam.bs.model.Product;
import com.bam.bs.repository.BillRepository;
import com.bam.bs.service.BillService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Messages;
import com.bam.bs.util.Utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Bill saveBill(BillDto billDto) {
		Bill bill = mapBill(billDto);
		bill.getProducts().stream().forEach(e -> e.setBill(bill));
		billRepository.save(bill);
		if (bill.getId() != null) {
			String s = simpleDateFormat.format(bill.getCreationDate());
			bill.setInvoiceName(String.format("BS-%s%05d", s, bill.getId()));
			billRepository.save(bill);
			return bill;
		} else {
			throw new CommonException("Save failed", "OPERATION_FAILED");
		}
	}

	@Override
	public Bill updateBill(BillDto billDto) {
		Bill bill = mapBill(billDto);
		bill.getProducts().stream().forEach(e -> e.setBill(bill));
		billRepository.save(bill);
		if (bill.getId() != null)
			return bill;
		else
			throw new CommonException("Update failed", "OPERATION_FAILED");
	}

	public List<Bill> search(BillRequest billRequest) {

		List<Predicate> predicates = new ArrayList<>();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Bill> criteriaQuery = criteriaBuilder.createQuery(Bill.class);
		Root<Bill> billRoot = criteriaQuery.from(Bill.class);

		if (!Utils.isNullOrEmpty(billRequest.getInvoiceNumber())) {
			predicates.add(criteriaBuilder.equal(billRoot.get("invoiceName"), billRequest.getInvoiceNumber()));
		} else {
			if (Objects.nonNull(billRequest.getCustomer()) && Objects.nonNull(billRequest.getCustomer().getId())) {
				predicates.add(
						criteriaBuilder.equal(billRoot.get("customer").get("id"), billRequest.getCustomer().getId()));
			}
			if (Objects.nonNull(billRequest.getStartDate()) && Objects.nonNull(billRequest.getEndDate())) {
				predicates.add(criteriaBuilder.between(billRoot.get("creationDate"), billRequest.getStartDate(),
						billRequest.getEndDate()));
			}
		}
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));
		EntityGraph<?> entityGraph = entityManager.getEntityGraph("graph.Bill");

		TypedQuery<Bill> typedQuery = entityManager.createQuery(criteriaQuery).setHint("javax.persistence.loadgraph",
				entityGraph);

		return typedQuery.getResultList();
	}

	@Override
	public List<SearchBillResponse> searchBills(BillRequest billRequest) {
		List<SearchBillResponse> billResponses = new ArrayList<>();
		List<Bill> billList = search(billRequest);
		if (Utils.isNullOrEmpty(billList)) {
			throw new CommonException("No records found", "NOT_FOUND");
		}
		billList.stream().forEach(bill -> {
			SearchBillResponse billResponse = new SearchBillResponse();
			billResponse.setId(bill.getId());
			billResponse.setCustomerName(bill.getCustomer().getName());
			billResponse.setDate(bill.getCreationDate());
			billResponse.setInvoice(bill.getInvoiceName());
			billResponse.setPlace(bill.getCustomer().getCity());
			billResponse.setInvoiceAmount(getInvoiceAmount(bill));
			billResponse.setUserName(bill.getUser().getName());
			billResponses.add(billResponse);
		});
		return billResponses;
	}

	@Override
	public Message deleteBill(Long[] id) {
		billRepository.deleteAllById(id);
		return new Message(Messages.SUCCESS);
	}

	private Bill mapBill(BillDto billDto) {
		return modelMapper.map(billDto, Bill.class);
	}

	private String getInvoiceAmount(Bill bill) {
		double amount = 0.0;
		Iterator<Product> iterator = bill.getProducts().iterator();
		while (iterator.hasNext()) {
			amount = amount + iterator.next().getRate();
		}
		return "" + amount;
	}

}
