package cz.uhk.spring3.service;

import cz.uhk.spring3.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    void saveItem(Item item);
    Item getItem(long id);
    void deleteItem(Item item);
    List<Item> getAllItems();
}
