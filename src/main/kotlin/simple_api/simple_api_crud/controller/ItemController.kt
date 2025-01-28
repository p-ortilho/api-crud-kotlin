package simple_api.simple_api_crud.controller

import org.springframework.web.bind.annotation.*
import simple_api.simple_api_crud.model.Item

@RestController
@RequestMapping("/items")
class ItemController {
    private val items = mutableListOf<Item>()
    private var idCounter = 1 // Começa o contador de IDs a partir de 1.

    @GetMapping
    fun getAllItems(): List<Item> = items

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Int): Item? = items.find { it.id == id }

    @PostMapping("/novo-item")
    fun postItem(@RequestBody item: Item): Item {
        val newItem = Item(
            id = idCounter++, // Incrementa o ID automaticamente.
            nome = item.nome,
            descricao = item.descricao
        )
        items.add(newItem)
        return newItem
    }

    @PutMapping("/atualizar-item/{id}")
    fun putItem(
        @PathVariable id: Int,
        @RequestBody item: Item
    ): Item {
        // Validação do corpo do request
        if (item.nome.isBlank()) {
            throw IllegalArgumentException("Nome do item não foi fornecido ou está vazio")
        }
        if (item.descricao.isBlank()) {
            throw IllegalArgumentException("Descrição do item não foi fornecida ou está vazia")
        }

        // Localizar o item na lista
        val foundItem = items.find { it.id == id }
            ?: throw NoSuchElementException("Item com o ID $id não encontrado")

        // Atualizar os campos necessários (ignorar o ID no corpo do JSON)
        foundItem.nome = item.nome
        foundItem.descricao = item.descricao

        return foundItem
    }

    @DeleteMapping("/deletar-item/{id}")
    fun deleteItem(@PathVariable id: Int): Item? {
        val foundItem = items.find { it.id == id }
        if (foundItem != null) {
            items.removeIf { it.id == id }
        }
        return foundItem
    }
}