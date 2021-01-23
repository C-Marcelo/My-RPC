package entity.exception;

import enumeration.RpcError;

/**
 * @author myk
 */
public class RpcException extends RuntimeException{
    public RpcException(RpcError rpcError){
        super(rpcError.getMessage());
    }

    public RpcException(RpcError rpcError, String detail){
        super(rpcError.getMessage() + ":" + detail);
    }
}
