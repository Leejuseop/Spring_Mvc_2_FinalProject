package hello.item_service.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); 
    private static Long sequence = 0L;

    public Item save(Item item){  //상품명, 가격, 수량 설정된 상태로 넘어온 정보 내부메모리에 저장.
        item.setId(++sequence);
        store.put(item.getId(), item);

        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){ // (수정할 기존 아이템, 수정될 정보가 담긴 아이템)
        Item findItem = store.get(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
