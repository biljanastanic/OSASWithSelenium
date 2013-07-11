jQuery(function(){
    
    var pct=0;
    var handle=0;
    
    
    handle=setInterval(function(){
            $(".progressbar:first").reportprogress(++pct);
            if(pct==100){
                    clearInterval(handle);
                    pct=0;
            }
    } ,100);
});