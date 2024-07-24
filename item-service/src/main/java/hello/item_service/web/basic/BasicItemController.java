package hello.item_service.web.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.item_service.domain.item.Item;
import hello.item_service.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    /*
     * 이렇게 들어갈 자리인데 생성자가 딱 하나만 있으면 다 생략하고 @RequiredArgsConstructor사용가능.
     * 
     * @Autowired
     * public BasicItemController(ItemRepository itemRepository){
     * this.itemRepository = itemRepository;
     * }
     */

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);

        return "basic/items";
    }

    /*
     * 테스트용 데이터 추가
     * 
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("car", 100000, 10));
        itemRepository.save(new Item("house", 200000, 20));
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String save(){
        return "fsdjfldsf";
    }

}
