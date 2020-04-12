package com.bam.bs;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bam.bs.dto.BillDto;
import com.bam.bs.dto.CustomerDto;
import com.bam.bs.dto.ProductDto;
import com.bam.bs.dto.UserDto;
import com.bam.bs.service.BillService;
import com.bam.bs.service.CustomerService;
import com.bam.bs.service.UserService;
import com.bam.bs.util.BillType;
import com.bam.bs.util.CustomerType;
import com.bam.bs.util.PerValue;
import com.bam.bs.util.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BillingSystemApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    @Autowired
    private BillService billService;
    @Autowired
    PasswordEncoder encoder;
    Calendar cal = Calendar.getInstance();

    public static void main(String[] args) {
        SpringApplication.run(BillingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String state = "Tamil Nadu";
        String zipCode = "123123";
        CustomerDto balaji = new CustomerDto();
        balaji.setName("Balaji");
        balaji.setCity("Perambalur");
        balaji.setStreet("Muthu nagar");
        balaji.setPhoneNumber("7894561234");
        balaji.setCustomerType(CustomerType.NON_GST);
        balaji.setState(state);
        balaji.setZipCode(zipCode);

        CustomerDto edmund = new CustomerDto();
        edmund.setName("Edmund");
        edmund.setCity("Thanjarvur");
        edmund.setStreet("Some Street");
        edmund.setPhoneNumber("1234567899");
        edmund.setCustomerType(CustomerType.GST);
        edmund.setGstNo("123456789012345");
        edmund.setState(state);
        edmund.setZipCode(zipCode);

        CustomerDto malavan = new CustomerDto();
        malavan.setName("Malavan");
        malavan.setCity("Trichy");
        malavan.setStreet("Some Street");
        malavan.setPhoneNumber("4567891231");
        malavan.setGstNo("123456789012346");
        malavan.setCustomerType(CustomerType.GST);
        malavan.setState(state);
        malavan.setZipCode(zipCode);

        balaji = customerService.saveCustomer(balaji);
        edmund = customerService.saveCustomer(edmund);
        malavan = customerService.saveCustomer(malavan);

        UserDto admin = new UserDto();
        admin.setName("Admin");
        admin.setUserName("admin");
        admin.setPassword(encoder.encode("123"));
        admin.setRole(UserRole.ADMIN);

        UserDto employee = new UserDto();
        employee.setName("Employee");
        employee.setUserName("emp");
        employee.setPassword(encoder.encode("123"));
        employee.setRole(UserRole.EMPLOYEE);

        admin = userService.saveUser(admin);
        employee = userService.saveUser(employee);

        BillDto bill1 = getBill(BillType.GST, balaji, admin, "Invoice1", getDate(1));
        BillDto bill2 = getBill(BillType.NON_GST, malavan, employee, "Invoice2", getDate(2));
        BillDto bill3 = getBill(BillType.GST, edmund, admin, "Invoice3",getDate(3));
        BillDto bill4 = getBill(BillType.NON_GST, balaji, employee, "Invoice4", getDate(4));
        BillDto bill5 = getBill(BillType.GST, malavan, admin, "Invoice5", getDate(5));
        BillDto bill6 = getBill(BillType.NON_GST, edmund, employee, "Invoice6", getDate(6));
        BillDto bill7 = getBill(BillType.GST, malavan, admin, "Invoice7", getDate(7));
        BillDto bill8 = getBill(BillType.NON_GST, balaji, employee, "Invoice8", getDate(8));
        BillDto bill9 = getBill(BillType.GST, edmund, admin, "Invoice9", getDate(9));
        BillDto bill10 = getBill(BillType.NON_GST, malavan, employee, "Invoice10", getDate(10));

        billService.saveBill(bill1);
        billService.saveBill(bill2);
        billService.saveBill(bill3);
        billService.saveBill(bill4);
        billService.saveBill(bill5);
        billService.saveBill(bill6);
        billService.saveBill(bill7);
        billService.saveBill(bill8);
        billService.saveBill(bill9);
        billService.saveBill(bill10);

    }

    private BillDto getBill(BillType billType, CustomerDto customer, UserDto user, String invoice, Date date) {

        BillDto bill = new BillDto();
        bill.setBillType(billType);
        bill.setUser(user);
        bill.setCustomer(customer);
        bill.setInvoiceName(invoice);
        bill.setCreationDate(date);

        ProductDto p1 = getProduct("P1");
        ProductDto p2 = getProduct("P2");
        ProductDto p3 = getProduct("P3");
        ProductDto p4 = getProduct("P4");

        bill.setProducts(Stream.of(p1, p2, p3, p4).collect(Collectors.toSet()));
        return bill;
    }

    private ProductDto getProduct(String name) {
        ProductDto product = new ProductDto();
        product.setDescription(name);
        product.setHsnCode(name + "HSN");
        product.setPerValue(PerValue.BOX);
        product.setQuantity(12);
        product.setRate(12.0);
        product.setTaxPercentage(12);

        return product;
    }

    Date getDate(int month) {
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
}
