# 1. Questões de Qualidade de Software.


## 1.1 Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

**A qualidade de um software deve estar seguindo com excelência as necessidades explícitas e objetivos propostos pela equipe que o produz, é de extrema importância garantir um bom processo de desenvolvimento e com bons níveis de qualidade, mas sempre mantendo as necessidadedos dos usuários.**

**Acredito que os principais critérios para garantir a qualidade de software sejam:
facilidade de reparo,
adaptabilidade,
fácil entendimento e
boa documentação.**



## 1.2 Em qual etapa da implementação você considera a qualidade de software?
**Acredito que na etapa do Processo de Testes, pois é onde podemos
confirmar se os produtos e o processo seguem as cláusulas e os planos estabelecidos, e também identificar qualquer erro e/ou melhoria que poderia ser aplicado.**


## 2. Endpoint disponiveis na API

#### 2.1 **POST** - SALVAR CLIENTE
Exemplo:  http://localhost:8080/cliente
{
    "nome": "MARIA JOANA",
    "dataNascimento": "10/10/1970",
    "enderecos": [
        {
            "logradouro": "Rua 7 de setembro",
            "numero": "AP 1",
            "cidade": "RIO DE JANEIRO",
            "cep": "21123456"
        }
    ]
} 
#### 2.2 **GET** - PESQUISAR TODOS OS CLIENTE
Exemplo: http://localhost:8080/cliente

#### 2.3 **GET** - PESQUISAR POR ID DO CLIENTE 
Exemplo: http://localhost:8080/cliente/1
#### 2.4 **PUT** - EDIÇÃO DO CLIENTE
Exemplo: http://localhost:8080/cliente/1
{
    "nome": "MARIA JOANA DOS SANTOS",
    "dataNascimento": "10/10/1971",
    "enderecos": [
        {
            "logradouro": "Rua da Cegonha",
            "numero": "AP 11",
            "cidade": "RIO DE JANEIRO",
            "cep": "21654321"
        }
    ]
}


####Observação:
Ao ser realizado a edição de cliente com um novo endereço, esse endereço não substitui o antigo. O novo endereço é atribuído ao id do cliente.

"# attornatusApi" 
