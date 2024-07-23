package hello.item_service.domain.item;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    public void AfterEach(){
        itemRepository.clearStore();
    }

    @Test
    public void save(){
        //given
        Item item = new Item("ItemA", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }


    @Test
    public void findAll(){
        //given
        Item item1 = new Item("ItemA", 10000, 10);
        Item item2 = new Item("ItemB", 20000, 20);

        //when
        itemRepository.save(item1);
        itemRepository.save(item2);
        List<Item> result = itemRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(item1, item2);
    }

    @Test
    public void updateItem(){
        //given
        Item item1 = new Item("ItemA", 10000, 10);
        Item item2 = new Item("ItemB", 20000, 20);

        //when
        itemRepository.save(item1);
        itemRepository.update(item1.getId(), item2);

        //then
        Assertions.assertThat(item1.getItemName()).isEqualTo(item2.getItemName());
        Assertions.assertThat(item1.getPrice()).isEqualTo(item2.getPrice());
        Assertions.assertThat(item1.getQuantity()).isEqualTo(item2.getQuantity());
    }
}
