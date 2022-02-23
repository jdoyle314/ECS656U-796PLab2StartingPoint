package com.example.grpc.server.grpcserver;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
@GrpcService
public class MatrixServiceImpl extends MatrixServiceGrpc.MatrixServiceImplBase
{
	@Override
	public void addBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
	{
		System.out.println("Request received from client:\n" + request);
		int C00=request.getA00()+request.getB00();
    		int C01=request.getA01()+request.getB01();
		int C10=request.getA10()+request.getB10();
		int C11=request.getA11()+request.getB11();
		MatrixReply response = MatrixReply.newBuilder().setC00(C00).setC01(C01).setC10(C10).setC11(C11).build();
		reply.onNext(response);
		reply.onCompleted();
	}
	@Override
    	public void multiplyBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
    	{
        	System.out.println("Request received from client:\n" + request);
        	int C00=request.getA00()*request.getB00()+request.getA01()*request.getB10();
		int C01=request.getA00()*request.getB01()+request.getA01()*request.getB11();
		int C10=request.getA10()*request.getB00()+request.getA11()*request.getB10();
		int C11=request.getA10()*request.getB01()+request.getA11()*request.getB11();
        MatrixReply response = MatrixReply.newBuilder().setC00(C00).setC01(C01).setC10(C10).setC11(C11).build();
        reply.onNext(response);
        reply.onCompleted();
    }
}
