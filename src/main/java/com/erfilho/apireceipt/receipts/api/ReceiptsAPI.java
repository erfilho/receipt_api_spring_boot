package com.erfilho.apireceipt.receipts.api;

import com.erfilho.apireceipt.receipts.dto.ReceiptDTO;
import com.erfilho.apireceipt.receipts.facade.ReceiptFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/receipts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptsAPI {
    @Autowired
    private ReceiptFacade receiptFacade;

    @PostMapping
    @ResponseBody
    public ReceiptDTO criar(@RequestBody ReceiptDTO receiptDTO){
        return receiptFacade.criar(receiptDTO);
    }

    @PutMapping("/{receiptId}")
    @ResponseBody
    public ReceiptDTO atualizar(@PathVariable("receiptId") Long receiptId,
                                @RequestBody ReceiptDTO receiptDTO){
        return receiptFacade.atualizar(receiptDTO, receiptId);
    }

    @GetMapping
    @ResponseBody
    public List<ReceiptDTO> getAll(){
        return  receiptFacade.getAll();
    }

    @DeleteMapping("/{receiptId}")
    @ResponseBody
    public String deletar(@PathVariable("receiptId") Long receiptId){
        return receiptFacade.delete(receiptId);
    }
}
