#### 状态模式

#### 背景
    如果一个函数中出现了过多的if else 就说明，这个函数中的责任过大了，　无论是任何状态，都需要通过它来改变，这是一种代码的坏味道。当我们要增加需求时，就会大段的修改　这部分的代码，同时也违背了　开发-封闭原则

    面向对象设计其实就是希望做到代码的责任分解。

    建议：
        把这些分支想办法变成一个又一个的类，增加时不会影响其他类。然后状态的变化在各自的类中完成。
        针对这种，我们可以使用状态模式

####
    状态模式，当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类

    状态模式主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。把状态的判断逻辑转移到表示不同状态的一系列类中，可以把复杂的判断逻辑简化。当然，如果这个判断很简单，那就没有必要用　状态模式



#### 状态模式好处与用处

    状态模式的好处是　将与特定状态相关的行为局部化，并且将不同状态的行为分割开来。

    将特定的状态相关的行为都放入一个对象中，由于所有与状态相关的代码都存在某个concreteState中，所以通过定义新的子类可以很容易地增加新的状态和转换。

    说白了，这样做的目的就是为了消除庞大的条件分支语句，大的分支判断会使得他们难以修改和扩展，就像我们最早说的刻板印刷一样，任何改动和变化都是致命的。状态模式通过把各种状态转移逻辑分布到　state子类之间，来减少相互的依赖。好比把整个版面改成了一个又一个的活字，此时就容易维护和拓展了。

#### 什么时候用状态模式

    当一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变它的行为时，就可以考虑使用状态模式了。

    另外，如果业务需求某项业务有多个状态，通常都是一些枚举常量，状态的变化都是依靠大量的分支判断语句来实现，此时应该考虑将每一种业务状态定义为一个state的子类，这样这些对象就可以不依赖于其他对象而独立变化了，某一天客户需要更改需求，增加或减少业务状态或改变状态流程，对你来说都是困难的事。