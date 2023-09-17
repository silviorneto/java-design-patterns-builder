package srn.desafiodesignpatterns.model.builder;

import srn.desafiodesignpatterns.model.Client;
import srn.desafiodesignpatterns.model.Order;

public class OrderBuilder {
//    Atributos obgrigatórios
    private String main;

//    Atributos opcionais
    private String drink;
    private String side;
    private String dessert;
    private String gift;

    private Client client;

    public OrderBuilder() {}

    public OrderBuilder addMain(String main) {
        this.main = main;
        return this;
    }
    public OrderBuilder forDrink(String drink){
        this.drink = drink;
        return this;
    }

    public OrderBuilder addDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    public OrderBuilder addSide(String side){
        this.side = side;
        return this;
    }

    public OrderBuilder addGift(String gift){
        this.gift = gift;
        return this;
    }

    public OrderBuilder toClient(Client client) {
        this.client = client;
        return this;
    }
    public Order thatsAll(){
        return new Order(drink, main, side, dessert, gift, client);
    }
}
