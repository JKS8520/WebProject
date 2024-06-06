package hgcq.appleshop.service;

import hgcq.appleshop.domain.Item;
import hgcq.appleshop.domain.status.ItemCategory;
import hgcq.appleshop.dto.ItemInfo;
import hgcq.appleshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemInfo detail(Long id) {
        Item item = itemRepository.findById(id);

        if (item == null) {
            throw new IllegalArgumentException("제품이 존재하지 않습니다.");
        }

        return parseItemInfo(item);
    }

    public List<ItemInfo> itemList(int id) {
        List<ItemInfo> itemList = new ArrayList<>();

        if (id == 1) {
            List<Item> items = itemRepository.findByCategoryOrderName(ItemCategory.MAC.toString());
            for (Item item : items) {
                ItemInfo itemInfo = parseItemInfo(item);
                itemList.add(itemInfo);
            }
        } else if (id == 2) {
            List<Item> items = itemRepository.findByCategoryOrderName(ItemCategory.IPAD.toString());
            for (Item item : items) {
                ItemInfo itemInfo = parseItemInfo(item);
                itemList.add(itemInfo);
            }
        } else if (id == 3) {
            List<Item> items = itemRepository.findByCategoryOrderName(ItemCategory.IPHONE.toString());
            for (Item item : items) {
                ItemInfo itemInfo = parseItemInfo(item);
                itemList.add(itemInfo);
            }
        } else if (id == 4) {
            List<Item> items = itemRepository.findByCategoryOrderName(ItemCategory.WATCH.toString());
            for (Item item : items) {
                ItemInfo itemInfo = parseItemInfo(item);
                itemList.add(itemInfo);
            }
        } else if (id == 5) {
            List<Item> items = itemRepository.findByCategoryOrderName(ItemCategory.AIRPODS.toString());
            for (Item item : items) {
                ItemInfo itemInfo = parseItemInfo(item);
                itemList.add(itemInfo);
            }
        } else if (id == 6) {
            List<Item> items = itemRepository.findByCategoryOrderName(ItemCategory.ACCESSORY.toString());
            for (Item item : items) {
                ItemInfo itemInfo = parseItemInfo(item);
                itemList.add(itemInfo);
            }
        } else {
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }

        return itemList;
    }

    public List<ItemInfo> itemListByPrice(int id, int measure) {
        List<ItemInfo> itemList = new ArrayList<>();
        List<Item> items;

        if (id == 1) {
            if (measure == 1) {
                items  = itemRepository.findByCategoryOrderPrice(ItemCategory.MAC.toString());
            } else if (measure == 2) {
                items  = itemRepository.findByCategoryOrderPriceDesc(ItemCategory.MAC.toString());
            } else {
                throw new IllegalArgumentException("정렬 방법이 잘못됐습니다.");
            }
        } else if (id == 2) {
            if (measure == 1) {
                items  = itemRepository.findByCategoryOrderPrice(ItemCategory.IPAD.toString());
            } else if (measure == 2) {
                items  = itemRepository.findByCategoryOrderPriceDesc(ItemCategory.IPAD.toString());
            } else {
                throw new IllegalArgumentException("정렬 방법이 잘못됐습니다.");
            }
        } else if (id == 3) {
            if (measure == 1) {
                items  = itemRepository.findByCategoryOrderPrice(ItemCategory.IPHONE.toString());
            } else if (measure == 2) {
                items  = itemRepository.findByCategoryOrderPriceDesc(ItemCategory.IPHONE.toString());
            } else {
                throw new IllegalArgumentException("정렬 방법이 잘못됐습니다.");
            }
        } else if (id == 4) {
            if (measure == 1) {
                items  = itemRepository.findByCategoryOrderPrice(ItemCategory.WATCH.toString());
            } else if (measure == 2) {
                items  = itemRepository.findByCategoryOrderPriceDesc(ItemCategory.WATCH.toString());
            } else {
                throw new IllegalArgumentException("정렬 방법이 잘못됐습니다.");
            }
        } else if (id == 5) {
            if (measure == 1) {
                items  = itemRepository.findByCategoryOrderPrice(ItemCategory.AIRPODS.toString());
            } else if (measure == 2) {
                items  = itemRepository.findByCategoryOrderPriceDesc(ItemCategory.AIRPODS.toString());
            } else {
                throw new IllegalArgumentException("정렬 방법이 잘못됐습니다.");
            }
        } else if (id == 6) {
            if (measure == 1) {
                items  = itemRepository.findByCategoryOrderPrice(ItemCategory.ACCESSORY.toString());
            } else if (measure == 2) {
                items  = itemRepository.findByCategoryOrderPriceDesc(ItemCategory.ACCESSORY.toString());
            } else {
                throw new IllegalArgumentException("정렬 방법이 잘못됐습니다.");
            }
        } else {
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }

        for (Item item : items) {
            ItemInfo itemInfo = parseItemInfo(item);
            itemList.add(itemInfo);
        }

        return itemList;
    }

    private ItemInfo parseItemInfo(Item item) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setId(item.getId());
        itemInfo.setName(item.getName());
        itemInfo.setImage(item.getImage());
        itemInfo.setPrice(item.getPrice());
        itemInfo.setDiscount(item.getDiscount());
        itemInfo.discountPrice();
        itemInfo.setViews(item.getViews());
        itemInfo.setOrders(item.getOrders());
        return itemInfo;
    }
}
