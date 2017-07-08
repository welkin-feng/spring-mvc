/**
 * 
 */
/**
 * @author Welkin
 * 
 * 这个 Manager 接口中的方法是 java 服务器中的基础业务（功能），这些功能在接口中定义是为了与方法实现分离，
 * 因为使用不同环境的人会有不同的实现方法，总之只有有一个类把这个接口实现了就行。
 * 这个 Manager  类与 Mapper 类有关，因为这个类中的方法要实现的功能是与数据库相关的，
 * 所以这个Manager接口的实现类会用到 Mapper 中的方法。也可以认为这个类中的方法是将 Mapper 中的方法进行组合。
 *
 */
package neusoft.test.module.service;