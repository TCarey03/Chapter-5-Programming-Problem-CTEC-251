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

--------------------------------

Phase 3 Journal Entry

Hidden Dependencies

In Phase 3, I created two game subsystems: AudioSystem and GraphicsRenderer. Both classes access the ConfigurationManager Singleton directly using ConfigurationManager.getInstance().

The constructors for my subsystem classes do not show that they depend on the ConfigurationManager. For example:

AudioSystem audio = new AudioSystem();

A developer looking only at this constructor would not know that AudioSystem depends on ConfigurationManager.

This is called a hidden dependency because the dependency exists inside the class instead of being explicitly provided to the class.

Hidden dependencies can make unit testing more difficult. If I wanted to test AudioSystem with a different configuration, I cannot simply pass a test configuration into its constructor. The class always accesses the Singleton directly.

The Singleton makes accessing shared configuration convenient, but it also creates tighter coupling between the subsystems and ConfigurationManager.

---------------------------------

Phase 4 Journal Entry

Singleton Reflection

The Singleton made it convenient to connect multiple game subsystems to the same configuration. The AudioSystem and GraphicsRenderer can access the ConfigurationManager without needing a configuration object passed into their constructors.

This made it easy for the interactive console to change settings and have the changes immediately available to the other subsystems. For example, when the AudioSystem changes the volume, the updated volume can be accessed by the ConfigurationManager and other parts of the program.

However, the Singleton also has drawbacks. It creates global state, which can make a program more difficult to test and can create hidden dependencies. A class that directly calls ConfigurationManager.getInstance() depends on the Singleton even though that dependency is not visible in its constructor.

A Singleton can be appropriate when an application truly needs one shared instance, such as a configuration manager where having multiple conflicting configurations would cause problems.

Dependency Injection can be a better choice when classes need to be independent and easy to test. With Dependency Injection, the required object can be passed into a class explicitly. This makes the dependency easier to see and allows a test to provide a different or mock object.

Overall, the Singleton was useful for this game engine because it provided one shared configuration, but it also demonstrated the trade-off between convenience and loose coupling.
