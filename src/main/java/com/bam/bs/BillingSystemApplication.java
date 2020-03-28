package com.bam.bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillingSystemApplication  {
	
//    private final CustomerRepository customerRepository;
//    private final UserRepository userRepository;
//    private final BillRepository billRepository;
//
//    @Autowired
//    public BillingSystemApplication(CustomerRepository customerRepository, UserRepository userRepository, BillRepository billRepository) {
//        this.customerRepository = customerRepository;
//        this.userRepository = userRepository;
//        this.billRepository = billRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(BillingSystemApplication.class, args);
    }
//
//    @Override
//    public void run(String... args) {
//        Customer balaji = new Customer();
//        balaji.setName("Balaji");
//        balaji.setCity("Perambalur");
//        balaji.setStreet("Muthu nagar");
//        balaji.setPhoneNumber("7894561234");
//        balaji.setCustomerType(CustomerType.GST);
//        balaji.setGstNo("123456789012345");
//
//        Customer edmund = new Customer();
//        edmund.setName("Edmund");
//        edmund.setCity("Thanjarvur");
//        edmund.setStreet("Some Street");
//        edmund.setPhoneNumber("1234567899");
//        edmund.setCustomerType(CustomerType.NON_GST);
//        edmund.setGstNo(null);
//
//        Customer malavan = new Customer();
//        malavan.setName("Malavan");
//        malavan.setCity("Trichy");
//        malavan.setStreet("Some Street");
//        malavan.setPhoneNumber("4567891231");
//        malavan.setCustomerType(CustomerType.NON_GST);
//        malavan.setGstNo(null);
//
//        customerRepository.saveAll(Stream.of(balaji, edmund, malavan).collect(Collectors.toList()));
//
//
//        User admin = new User();
//        admin.setName("Admin");
//        admin.setUserName("admin");
//        admin.setPassword("123");
//        admin.setRole(Role.ADMIN);
//
//        User employee = new User();
//        employee.setName("Employee");
//        employee.setUserName("emp");
//        employee.setPassword("123");
//        employee.setRole(Role.EMPLOYEE);
//
//        userRepository.saveAll(Stream.of(admin, employee).collect(Collectors.toList()));
//
//        Bill bill1 = getBill(BillType.GST, balaji, admin, "Invoice1");
//        Bill bill2 = getBill(BillType.NON_GST, malavan, employee, "Invoice2");
//        Bill bill3 = getBill(BillType.GST, edmund, admin, "Invoice3");
//        Bill bill4 = getBill(BillType.NON_GST, balaji, employee, "Invoice4");
//        Bill bill5 = getBill(BillType.GST, malavan, admin, "Invoice5");
//        Bill bill6 = getBill(BillType.NON_GST, edmund, employee, "Invoice6");
//        Bill bill7 = getBill(BillType.GST, malavan, admin, "Invoice7");
//        Bill bill8 = getBill(BillType.NON_GST, balaji, employee, "Invoice8");
//        Bill bill9 = getBill(BillType.GST, edmund, admin, "Invoice9");
//        Bill bill10 = getBill(BillType.NON_GST, malavan, employee, "Invoice10");
//
//        billRepository.saveAll(Stream.of(bill1, bill2, bill3, bill4, bill5, bill6, bill7, bill8, bill9, bill10).collect(Collectors.toSet()));
//
//
//    }
//
//    private Bill getBill(BillType billType, Customer customer, User user, String invoice) {
//
//        Bill bill = new Bill();
//        bill.setBillType(billType);
//        bill.setUser(user);
//        bill.setCustomer(customer);
//        bill.setInvoiceName(invoice);
//        bill.setCreationDate(LocalDate.now());
//
//
//        Product p1 = getProduct("P1");
//        p1.setBill(bill);
//        Product p2 = getProduct("P2");
//        p2.setBill(bill);
//        Product p3 = getProduct("P3");
//        p3.setBill(bill);
//        Product p4 = getProduct("P4");
//        p4.setBill(bill);
//
//        bill.setProducts(Stream.of(p1, p2, p3, p4).collect(Collectors.toSet()));
//        return bill;
//    }
//
//    private Product getProduct(String name) {
//        Product product = new Product();
//        product.setName(name);
//        product.setHsnCode(name + "HSN");
//        product.setPerValue(PerValue.BOX);
//        product.setQuantity(12);
//        product.setRate(12.0);
//        product.setTaxPercentage(12);
//
//        return product;
//    }

}