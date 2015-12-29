# EventBusTest
Simple Test EventBus



    public void onEvent(Data data){
        Log.e("test", "onEvent:" + data.msg);
    }
    public void onEventMainThread(Data data){
        Log.e("test","onEventMainThread:"+ data.msg);
        textView.setText(data.msg);
    }

    public void onEventBackgroundThread(Data data){
        Log.e("test", "onEventBackgroundThread:" + data.msg);
    }
    public void onEventAsync(Data data){
        Log.e("test", "onEventAsync：" + data.msg);
    }
    
    
    
    
