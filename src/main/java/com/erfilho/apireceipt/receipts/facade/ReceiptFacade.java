package com.erfilho.apireceipt.receipts.facade;

import com.erfilho.apireceipt.receipts.dto.ReceiptDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReceiptFacade {
    private static final Map<Long, ReceiptDTO> receipts = new HashMap<>();

    public ReceiptDTO criar(ReceiptDTO receiptDTO){
        Long proxId = receipts.keySet().size()+1L;
        receiptDTO.setId(proxId);
        receipts.put(proxId, receiptDTO);
        return receiptDTO;
    }

    public ReceiptDTO atualizar(ReceiptDTO receiptDTO, Long receiptId){
        receipts.put(receiptId, receiptDTO);
        return receiptDTO;
    }

    public ReceiptDTO getById(Long receiptId){
        return receipts.get(receiptId);
    }

    public List<ReceiptDTO> getAll(){
        return new ArrayList<>(receipts.values());
    }

    public String delete(Long receiptId){
        receipts.remove(receiptId);
        return "Deleted";
    }
}
