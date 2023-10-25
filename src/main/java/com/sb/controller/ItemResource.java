package com.sb.controller;

import com.sb.model.Item;
import com.sb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Autowired
    private ItemRepository itemRepository;


    @GET
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GET
    @Path("/getItem/{id}")
    public Item getItemById(@PathParam("id") Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @POST
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @PUT
    @Path("/{id}")
    public Item updateItem(@PathParam("id") Long id, Item updatedItem) {
        updatedItem.setId(id);
        return itemRepository.save(updatedItem);
    }

    @DELETE
    @Path("/{id}")
    public void deleteItem(@PathParam("id") Long id) {
        itemRepository.deleteById(id);
    }
}
