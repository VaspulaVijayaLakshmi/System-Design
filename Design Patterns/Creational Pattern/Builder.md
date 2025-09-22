Builder class is defined inside the class, as static class, so it can be accesed with the class Name.

Constructor can be made private to be not called from outside.
Because we want user to stritcly follow this pattern.

Build method - that returns the object class in the end.


```java
public Pizza build(){

new Pizza(size,topping,...)
}
```


What doe this line do?

```
Pizza pizza = new Pizza.Builder("Large")
```


****
```
Pizza.Builder("Large")

What it is:
Builder is a static inner class inside Pizza.
Pizza.Builder("Large") creates a new Builder object and calls its constructor with "Large" as the size.


What it returns:

It returns a Builder object, not a Pizza.
This is why you can chain methods on it:

new Pizza.Builder("Large").addCheese().addPepperoni()


addCheese() returns the same Builder object (this)
addPepperoni() returns the same Builder object
Finally, build() returns the actual Pizza object.


So Builder methods always return the Builder itself until you call build(), which gives the final Pizza.
```




```java
class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;

    private Pizza(String size, boolean cheese, boolean pepperoni) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
    }

    // Builder
    public static class Builder {
        private String size;
        private boolean cheese = false;
        private boolean pepperoni = false;

        public Builder(String size) {
            this.size = size;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(size, cheese, pepperoni);
        }
    }
}

// Usage
Pizza pizza = new Pizza.Builder("Large")
                  .addCheese()
                  .addPepperoni()
                  .build();


```



![image](https://github.com/user-attachments/assets/4e8f0ba3-7beb-41ed-874e-e688a841b313)
