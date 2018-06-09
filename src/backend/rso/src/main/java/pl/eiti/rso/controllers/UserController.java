package pl.eiti.rso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.eiti.rso.domain.entity.Address;
import pl.eiti.rso.domain.entity.Customer;
import pl.eiti.rso.domain.entity.CustomerBusiness;
import pl.eiti.rso.domain.entity.CustomerIndividual;
import pl.eiti.rso.domain.repositories.CustomerRepository;
import pl.eiti.rso.domain.repositories.HibernateDaoImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    HibernateDaoImpl hibernateDao;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/saveOrUpdateCustomerIndividual", method = RequestMethod.PUT)
    public void saveOrUpdateCustomerIndividual(@RequestBody CustomerIndividual customerIndividual) {
        hibernateDao.saveAndFlash(customerIndividual);
    }

    @RequestMapping(value = "/saveOrUpdateCustomerBusiness", method = RequestMethod.PUT)
    public void saveOrUpdateCustomerIndividual(@RequestBody CustomerBusiness customerBusiness) {
        hibernateDao.saveAndFlash(customerBusiness);
    }

    @RequestMapping(value = "/getCustomerBusiness/{id}", method = RequestMethod.GET)
    public CustomerIndividual getCustomerIndividual(@PathVariable Long id) {
        return (CustomerIndividual) hibernateDao.getEntity(CustomerIndividual.class, id);
    }

    @RequestMapping(value = "/getCustomerIndividual/{id}", method = RequestMethod.GET)
    public CustomerBusiness getCustomerBusiness(@PathVariable Long id) {
        return (CustomerBusiness) hibernateDao.getEntity(CustomerBusiness.class, id);
    }

    @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        return (Customer) hibernateDao.getEntity(Customer.class, id);
    }

    @RequestMapping(value = "/testCUSTOMER", method = RequestMethod.GET)
    public void test() {
        hibernateDao.saveAndFlash(new CustomerIndividual("Kamil", "Kamil", "123456789", "aaa@o2.pl"));
        hibernateDao.saveAndFlash(new CustomerBusiness("FirmaKamil", "8976543", "aFrima@o2.pl"));
        Address address = new Address();
        address.setCountry("Polska");
        address.setCity("Warszawa");
        CustomerIndividual customerIndividual = new CustomerIndividual();
        CustomerBusiness customerBusiness = new CustomerBusiness();
        customerBusiness.setCompanyName("Firma-Moja");
        customerBusiness.setDeliveryAddress(address);
        customerBusiness.setEmail("moja@o2.pl");
        customerIndividual.setFirstName("Kamil");
        customerIndividual.setDeliveryAddress(address);
        customerIndividual.setEmail("kamil@o2.pl");
        hibernateDao.save(customerIndividual);
        hibernateDao.save(customerBusiness);
        hibernateDao.flush();
    }

    @RequestMapping(value = "/clean", method = RequestMethod.GET)
    public void clean() {
        customerRepository.deleteAll();
    }


    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        ArrayList<Customer> list = new ArrayList<Customer>();
        customerRepository.findAll().forEach(list::add);
        return list;
    }

    public HibernateDaoImpl getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDaoImpl hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
