package com.example.day3bank;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bank")
public class Controller {

    ArrayList<Customers> cus = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customers> getCus()
    {
        return cus;
    }

    @PostMapping("/addCus")
    public APIResponse addCus(@RequestBody Customers c)
    {
        cus.add(c);
        return new APIResponse("Cus Added!!");
    }
    @DeleteMapping("/delete/{i}")
    public APIResponse deleteCus(@PathVariable int i)
    {
        cus.remove(i);
        return new APIResponse("Cus Removes!!");
    }

    @PutMapping("/dep/{i}")
    public APIResponse dep(@PathVariable int i , @RequestBody int amount)
    {
        for( int x = 0 ; x < cus.size() ; x++)
        {
            if(cus.get(x).getId() == i)
            {
                cus.get(x).setBalance(cus.get(x).getBalance()+amount);
                return new APIResponse("Amount Added");
            }
        }
        return new APIResponse("Cus NOT FOUND!!!");

    }

    @PutMapping("/with/{i}")
    public APIResponse withdraw(@PathVariable int i , @RequestBody int amount )
    {
        for( int x = 0 ; x < cus.size() ; x++)
        {
            if(cus.get(x).getId() == i)
            {
                if(cus.get(x).getBalance() - amount >= 0)
                {
                    cus.get(x).setBalance(cus.get(x).getBalance()-amount);
                    return new APIResponse("Amount withdrawed!!");
                }else
                    return new APIResponse("Not Enough Balance!!");
            }
        }
        return new APIResponse("Cus NOT FOUND!!!");
    }

}
