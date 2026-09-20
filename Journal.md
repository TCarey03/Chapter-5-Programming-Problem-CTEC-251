Phase 1 Journal

Why does checking reference equality between two variables retrieved from `getInstance()` confirm that you have a Singleton?

Reference equality checks whether two variables point to the exact same object in memory. In my program, I call `getInstance()` twice and store the results in `config1` and `config2`. When I use `config1 == config2`, the result is `true`, which shows that both variables refer to the same ConfigurationManager object.

The private constructor prevents other classes from directly creating a ConfigurationManager object. This means code outside the class cannot use `new ConfigurationManager()`.

The static `getInstance()` method provides the single way for other classes to access the ConfigurationManager. Because the instance is also static, it belongs to the class instead of a particular object.

I used eager initialization by creating the instance when the class is loaded:

```java
private static final ConfigurationManager instance =
        new ConfigurationManager();
```

This ensures that the Singleton object already exists when `getInstance()` is called.
