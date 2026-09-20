Phase 1 Journal

Why does checking reference equality between two variables retrieved from getInstance() confirm that you have a Singleton?

Reference equality checks whether two variables point to the exact same object in memory. In my program, I call getInstance() twice and store the results in `config1` and `config2`. When I use `config1 == config2`, the result is true, which shows that both variables refer to the same ConfigurationManager object.

The private constructor prevents other classes from directly creating a ConfigurationManager object. This means code outside the class cannot use `new ConfigurationManager()`.

The static getInstance() method provides the single way for other classes to access the ConfigurationManager. Because the instance is also static, it belongs to the class instead of a particular object.

I used eager initialization by creating the instance when the class is loaded:

private static final ConfigurationManager instance =
        new ConfigurationManager();

This ensures that the Singleton object already exists when getInstance() is called.

-------------------------------

Phase 2 Journal Entry

Compare eager initialization to lazy initialization.

In Phase 1, I used eager initialization. This meant the ConfigurationManager object was created when the class was loaded, even if the program had not requested the configuration yet.

In Phase 2, I changed the Singleton to use lazy initialization. The instance starts as null, and the getInstance() method checks whether the object has already been created. If it has not, the method creates it.

if (instance == null) {
    instance = new ConfigurationManager();
}

I would prefer lazy loading when creating an object is expensive or uses a lot of resources. For example, if the ConfigurationManager had to read a large configuration file from disk, it could be useful to wait until the configuration is actually needed before creating the object.

The main trade-off is that the object is created later, which can make the first call to getInstance() take longer. Lazy initialization can also require additional care in programs with multiple threads to make sure two objects are not accidentally created at the same time.

For this project, lazy initialization demonstrates that the Singleton can still provide one shared object while delaying its creation until it is actually needed.

