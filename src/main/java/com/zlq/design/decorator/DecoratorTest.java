package com.zlq.design;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.design
 * @ClassName: DecoratorTest
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/18 16:32
 */
public class DecoratorTest {

    public static void main(String[] args) {
        // 使用示例
        Pizza pizza = new PlainPizza();
        pizza = new Cheese(pizza);
        pizza = new Pepperoni(pizza);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());
    }


}

// 使用示例
// 抽象组件
interface Pizza {
    String getDescription();

    double getCost();
}

// 具体组件
class PlainPizza implements Pizza {
    public String getDescription() {
        return "Plain Pizza";
    }

    public double getCost() {
        return 4.00;
    }
}

// 抽象装饰器
class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

// 具体装饰器
class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}

class Pepperoni extends ToppingDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    public double getCost() {
        return pizza.getCost() + 2.00;
    }
}

