package dev.akhtar.ProductService.services;


import dev.akhtar.ProductService.models.BeeAccount;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BeeBankService {

    BeeAccount beeAccount1= BeeAccount.builder().id(11L).accountNumber("34297493447").balance(BigDecimal.valueOf(8945)).build();

    BeeAccount beeAccount2= BeeAccount.builder().id(12L).accountNumber("847357493447").balance(BigDecimal.valueOf(9837456)).build();

    BeeAccount beeAccount3= BeeAccount.builder().id(13L).accountNumber("9830740493447").balance(BigDecimal.valueOf(398475)).build();

    List<BeeAccount> beeAccounts= List.of(beeAccount1,beeAccount2,beeAccount3);
    public BeeAccount deposit(Long id,Long amount){
        BigDecimal amountToBeAdded= BigDecimal.valueOf(amount);
        BeeAccount b= findById(id);
        b.setBalance(b.getBalance().add(amountToBeAdded));

    }

    public BeeAccount withdraw(Long id,Long amount) throws Exception {
        BigDecimal amountToBeWithdrawn= BigDecimal.valueOf(amount);
        BeeAccount b= findById(id);
        if(b.getBalance()>amountToBeWithdrawn{
            b.setBalance(b.getBalance().subtract(amountToBeAdded));
        }else{
            throw new Exception("You dont have enough balace");
        }

    }

    public BeeAccount getAccountDetails(Long id) throws Exception {
        return findById(id);
    }

    private BeeAccount findById(Long id) throws Exception {
//        for(BeeAccount b:beeAccounts){
//            if(b.getId()==id){
//                return b;
//            }
//        }
//        throw new Exception("Account not found");

        return beeAccounts.stream().filter(a->a.getId()==id).findFirst().get();
    }
}
