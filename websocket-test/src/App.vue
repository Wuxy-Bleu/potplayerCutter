<template>
  <div id="app">
    <p>sjdlfkajsdfaskf</p>
  </div>
</template>

<script>
export default {
  name: 'App',
data(){
    websocketObj: null,
    wsHeartflag: false,
    reconnectTime: 0
},
created(){
    this.initWebsocket();
},
methods: {
    initWebsocket(){
        if (websocket in window) {
            this.webSocketObj = new WebSocket(
                "wss://"+newApi+"/websocket?sid="+userToken
            );
            this.webSocketObj.onmessage = this.onMessage
            this.webSocketObj.onopen = this.onOpen
            this.webSocketObj.onerror = this.onError
            this.webSocketObj.onclose = this.onClose
        }  
    }
}
}
</script>

<style>
</style>
