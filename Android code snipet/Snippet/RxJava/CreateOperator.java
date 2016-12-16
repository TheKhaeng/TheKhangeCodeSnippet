// RxJava 1.*

//1. Do not use create in RxJava 1.*
Observable.create( new Observable.OnSubscribe<Object>(){
      @Override
      public void call( Subscriber<? super Object> subscriber ){
        try {
          subscriber.onNext(downloadFileFromNetwork());
          subscriber.onCompleted();
        } catch (IOException e) {
          subscriber.onError(e);
        }
      }
    }
);

//2. Observable.defer() is still useful if you need to return Observable instead of a value.
Observable.defer(new Func0<Observable<Gist>>(){
        @Override
        public Observable<Gist> call(){
            try{
                return Observable.just(downloadFileFromNetwork());
            }catch( IOException e ){
                return Observable.error( e );
            }
        }
    }
);

//3. easy thing as deferring code execution!
Observable.fromCallable( new Callable<String>(){
    @Override
    public String call() throws Exception{
        return downloadFileFromNetwork();
    }
} );
