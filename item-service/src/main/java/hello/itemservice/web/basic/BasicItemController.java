package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    //@PostMapping("/add")
    public String addItemV1(@RequestParam String itemName, @RequestParam int price, @RequestParam Integer quantity, Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemRepository.save(item);
        model.addAttribute("item", item);
        return "basic/item";
    }

    // @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item) {
        itemRepository.save(item);
        //model.addAttribute("item",item); @ModelAttribute를 쓰면 addAtribute, 파라미터에서 Model model을 생략해도 괜찮다
        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        //@ModelAttribute에서 ("item")을 생략하면 Item에서 첫 글자를 소문자로 변환 후 모델에 넣어준다
        itemRepository.save(item);
        //model.addAttribute("item",item);
        return "basic/item";
    }

    //  @PostMapping("/add")
    public String addItemV4(Item item) { //단순 타입이 아닌 Item 클래스같은 사용자 지정 타입은 자동으로 @ModelAttribute가 적용,..
        itemRepository.save(item);
        //model.addAttribute("item",item);
        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV5(Item item) {
        itemRepository.save(item);
        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/delete/{itemId}")
    public String deleteItem(@PathVariable Long itemId) {
        itemRepository.delete(itemId);
        return "redirect:/basic/items";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }


    @PostConstruct //테스트코드용 데이터
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}
