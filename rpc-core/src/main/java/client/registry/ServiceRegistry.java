package client.registry;

/**
 * @author myk
 */
public interface ServiceRegistry {
     <T> void register(T service);

     Object getService (String serviceName);
}
