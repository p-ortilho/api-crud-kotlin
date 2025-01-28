package simple_api.simple_api_crud.model

// Classe de modelagem dos item
class Item(
    val id: Int,        // Propriedade imutável - val
    var nome: String,   // Propriedade mutável - var
    var descricao: String // Propriedade mutável - var
)