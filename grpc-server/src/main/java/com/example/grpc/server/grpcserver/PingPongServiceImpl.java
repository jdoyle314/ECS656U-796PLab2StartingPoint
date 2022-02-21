package com.example.grpc.server.grpcserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void ping(
        PingRequest request, StreamObserver<PongResponse> responseObserver) {        
		String ping = new StringBuilder()
                .append("pong")
                .toString();        
		PongResponse response = PongResponse.newBuilder()
                .setPong(ping)
                .build();        
		responseObserver.onNext(response);
        	responseObserver.onCompleted();
    }
}
