<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import= "com.xuantujava.util.SecurityUtils" %>
<c:url var ="userName" value="<%= SecurityUtils.getPrincipal().getFullName() %>"/>
<c:url var ="linkvideo" value="${linkvideo}" />
<c:url var ="statuslivestym" value="${statuslivestym}" />
<!DOCTYPE html>
<html>

<head>

</head>
<body >
	<c:if test="${statuslivestym == 1}">
		<h1>USER PAGE</h1>
	</c:if>
	<c:if test="${statuslivestym == 0}">
		<h1>NOW, It's have no Livestrym</h1>
	</c:if>
	
	
<div style="display: grid;grid-template-columns: auto auto auto;background-color:#bdc3c7;text-algin: center;">
	<div style="border: 1px solid rgba(0, 0, 0, 0.8);text-algin: center;  grid-column: 1 / 3"> 
	<!-- element1 -->
<!-- 	<h1 class="grid-item zxz">The DEMO LiveStream Class</h1> -->
	
	<!-- <iframe width="560" height="315" src="https://www.youtube.com/embed/s8taXR3mYa8?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen=""></iframe> -->
<!-- 	//autoplay -->
	<video id="myvid" width="100%" height="700px"  style="background-color:#95a5a6">
	  <source src="${linkvideo}" type="video/mp4">
	</video>
	</div>
	
	
	<div style="border: 1px solid rgba(0, 0, 0, 0.8);">
	<!-- element2 -->
	   <h4 style=" text-algin: center;">Live Chat Box:</h4>
		
		<div>
		    <div id="chat" class="chat" 
		    style="width:auto;height:500px;background-color:linen;	overflow:auto; display:flex; flex-direction:column-reverse;">
	    </div>
		</div>
	
	  
	    
	    <div style="display: grid;grid-template-columns: auto auto auto auto;">	  	   
		    <div style="grid-column: 1 / 5;padding-top:10px;">
			    <input style="height:100px;width:82%;" type="text" name="msg" id="msg" placeholder="Enter message here"/>	  
			    <button style="width:16%;height:100px;" onclick="return sendMsg();">Enter</button>  
		    </div>
		    
		    <div style="grid-column: 1 / 1;" >
		  		<button onClick="turnOffRecording()" style="width:100%;height:50px;">Turn <span id="audioStatus0"> OFF</span> Micro</button>
		    </div>
		    
		    <div style="grid-column: 2 / 4;text-align:center;padding-top:5px;">
				<!--  end audio -->
				<h3 style="width:100%;height:50px;">Audio: <span id="audioStatus"> TURN ON</span></h3> 
		    </div>
		       
		</div>
		    



		
	</div>
		

		
	</div>	
	
	
		<!--	--FOR SOCKET AND RTC. HIDDENED -->
	<div hidden>

	<div>
		<img style="float: left; width: auto; height: 50px"
			src="https://itsallbinary.com/wp-content/uploads/2017/03/final_itsallbinary.gif" />
		<h3 style="position: relative; left: 10px;">WebRTC Video Conferencing <br />Application Demo
		</h3>
	</div>
 
	Other person's camera video will show up here
	<div>
		<h3 style="margin: 5px">Other Person</h3>
		<video style="width: 50vh; height: 50vh;" id="remoteVideo"
			poster="https://img.icons8.com/fluent/48/000000/person-male.png" autoplay></video>
	</div>
 
	Your camera video will show up here.
	<div>
		<h3 style="margin: 5px">You</h3>
		<video style="width: auto; height: 20vh;" id="localVideo"
			poster="https://img.icons8.com/fluent/48/000000/person-male.png" autoplay muted></video>
	</div>
 
	<!-- Button to leave video conference. -->
	<div class="box">
		<button id="leaveButton" style="background-color: #008CBA; color: white; ">Leave Video Conference</button>
	</div>
	</div>
<script>
	// AUDIO
	
	var peerConnection;

var list = new Array();
var count = 0;

var localstream;
var holdX;

 /*
  * Setup 'leaveButton' button function.
  */
 const leaveButton = document.getElementById('leaveButton');
 leaveButton.addEventListener('click', leave);

 function leave() {
     console.log('Ending call');
     peerConnection.close();
     signalingWebsocket.close();
     window.location.href = './index.html';
 };
 
 var audioStatus=true;
 function turnOffRecording() {
	if(audioStatus == true){
		audioStatus = false;
		document.getElementById("audioStatus").innerHTML = "TURN OFF";
		document.getElementById("audioStatus0").innerHTML = "ON";

		
	}else if(audioStatus == false){
		audioStatus = true;	
		document.getElementById("audioStatus").innerHTML = "TURN ON";
		document.getElementById("audioStatus0").innerHTML = "OFF";

	}
	console.log(holdX);
	 var x = holdX.getAudioTracks();
		console.log(x);
		x[0].enabled = audioStatus;

	/// localstream.getAudioTracks()[0].enabled = false;

 
 };
 
 function clearStream(){
	 peerConnection1 = peerConnection;
	 peerConnection = null;
// 	 signalingWebsocket = null;
	 console.log("cleared");
	 
// 	 signalingWebsocket = new WebSocket(wsUrl + window.location.host + "/spring-mvc/signal");
		
	 init();
 }

 /*
  * Prepare websocket for signaling server endpoint.
  */
  
  var wsUrl;
  if (window.location.protocol == 'http:') {
      wsUrl = 'ws://';
  } else {
      wsUrl = 'wss://';
  }
  console.log("usURL: " + wsUrl);
  
  console.log(wsUrl + window.location.host + "/spring-mvc/signal");
  
  var signalingWebsocket = new WebSocket(wsUrl + window.location.host + "/spring-mvc/signal");
  
  signalingWebsocket.onopen = init();


 signalingWebsocket.onmessage = function(msg) {
     console.log("Got message", msg.data);
     var signal = JSON.parse(msg.data);
     switch (signal.type) {
         case "offer":
             handleOffer(signal);
             break;
         case "answer":
        	 console.log("answer: " + signal)
             handleAnswer(signal);
             break;
         // In local network, ICE candidates might not be generated.
         case "candidate":
             handleCandidate(signal);
             break;
         default:
             break;
     }
 };


 function sendSignal(signal) {
     if (signalingWebsocket.readyState == 1) {
         signalingWebsocket.send(JSON.stringify(signal));
     }
 };

 /*
  * Initialize
  */
 function init() {
     console.log("Connected to signaling endpoint. Now initializing.");    
     preparePeerConnection();
     displayLocalStreamAndSignal(true);
     list[count] = peerConnection;
     console.log("count:      ------      " + count);
 };

 /*
  * Prepare RTCPeerConnection & setup event handlers.
  */
 function preparePeerConnection() {
     
      // Using free public google STUN server.
     const configuration = {
         iceServers: [{
             urls: 'stun:stun.l.google.com:19302'
         }]
     };

     // Prepare peer connection object
     peerConnection = new RTCPeerConnection(configuration);
     peerConnection.onnegotiationneeded = async () => {
         console.log('onnegotiationneeded');
         sendOfferSignal();
     };
     peerConnection.onicecandidate = function(event) {
         if (event.candidate) {
         	sendSignal(event);
         }
     };
     
     /*
 	 * Track other participant's remote stream & display in UI when available.
 	 * 
 	 * This is how other participant's video & audio will start showing up on my
 	 * browser as soon as his local stream added to track of peer connection in
 	 * his UI.
 	 */
     peerConnection.addEventListener('track', displayRemoteStream);

 };

 /*
  * Display my local webcam & audio on UI.
  */
async function displayLocalStreamAndSignal(firstTime) {
     console.log('Requesting local stream');
     const localVideo = document.getElementById('localVideo');
     try {
         console.log('Received local stream1');

         // Capture local video & audio stream & set to local <video> DOM
         // element
         const stream = await navigator.mediaDevices.getUserMedia({
             audio: firstTime,
             video: false
         });
         console.log('Received local stream2');
         localVideo.srcObject = stream;
         localStream = stream;
         console.log("localstream: " +localstream);
         logVideoAudioTrackInfo(localStream);

         // For first time, add local stream to peer connection.
         if (firstTime) {
             setTimeout(
                 function() {
                     addLocalStreamToPeerConnection(localStream);
                 }, 2000);
         }

         // Send offer signal to signaling server endpoint.
         sendOfferSignal();

     } catch (e) {
         alert(`getUserMedia() error: ${e.name}`);
         throw e;
     }
     console.log('Start complete');
 };

 /*
  * Add local webcam & audio stream to peer connection so that other
  * participant's UI will be notified using 'track' event.
  * 
  * This is how my video & audio is sent to other participant's UI.
  
  */
 async function addLocalStreamToPeerConnection(localStream) {
     console.log('Starting addLocalStreamToPeerConnection');
     localStream.getTracks().forEach(track => peerConnection.addTrack(track, localStream));
     console.log('localStream tracks added');
 };

 /*
  * Display remote webcam & audio in UI.
  */
 function displayRemoteStream(e) {
     console.log('displayRemoteStream');
     const remoteVideo = document.getElementById('remoteVideo');
     if (remoteVideo.srcObject !== e.streams[0]) {
         remoteVideo.srcObject = e.streams[0];
         console.log('pc2 received remote stream');
     }
 };

 /*
  * Send offer to signaling server. This is kind of telling server that my webcam &
  * audio is ready, so notify other participant of my information so that he can
  * view & hear me using 'track' event.
  */
 function sendOfferSignal() {
     peerConnection.createOffer(function(offer) {
         sendSignal(offer);
         peerConnection.setLocalDescription(offer);
     }, function(error) {
         alert("Error creating an offer");
     });
 };

 /*
  * Handle the offer sent by other participant & send back answer to complete the
  * handshake.
  */
 function handleOffer(offer) {
	 console.log("newwwwwwwwwwwww" + count);

// 	 if(count == 0){
// 		 peerConnection = null;
// 		 signalingWebsocket.onopen = init();
// 	     count++;
// 		 console.log("newwwwwwwwwwwww count:" + count);
// 	 }
     peerConnection
         .setRemoteDescription(new RTCSessionDescription(offer));

     // create and send an answer to an offer
     peerConnection.createAnswer(function(answer) {
         peerConnection.setLocalDescription(answer);
         sendSignal(answer);
     }, function(error) {
    //     alert("Error creating an answer");
     });

 };

 /*
  * Finish the handshake by receiving the answer. Now Peer-to-peer connection is
  * established between my browser & other participant's browser. Since both
  * participants are tracking each others stream, they both will be able to view &
  * hear each other.
  */
 function handleAnswer(answer) {
     peerConnection.setRemoteDescription(new RTCSessionDescription(
         answer));
     console.log("connection established successfully!!");
 };

 /*
  * Add received ICE candidate to connection. ICE candidate has information about
  * how to connect to remote participant's browser. In local LAN connection, ICE
  * candidate might not be generated.
  */
 function handleCandidate(candidate) {
 	alert("handleCandidate");
     peerConnection.addIceCandidate(new RTCIceCandidate(candidate));
 };

 /*
  * Logs names of your webcam & microphone to console just for FYI.
  */
 function logVideoAudioTrackInfo(localStream) {
	  
	  console.log("xxxLOCALSTREAM: " + localStream);
	  holdX= localStream;
	  console.log("xxxLOCALSTREAM: " + holdX);

     const videoTracks = localStream.getVideoTracks();
     const audioTracks = localStream.getAudioTracks();
     if (videoTracks.length > 0) {
         console.log(`Using video device: ${videoTracks[0].label}`);
     }
     if (audioTracks.length > 0) {
         console.log(`Using audio device: ${audioTracks[0].label}`);
     }
 };
	
	
	
/// VIDEO + CHAT

    var wsUrl;
    if (window.location.protocol == 'http:') {
        wsUrl = 'ws://';
    } else {
        wsUrl = 'wss://';
    }
    console.log("usURL: " + wsUrl);
    console.log(wsUrl + window.location.host + "/spring-mvc/chat/${userName}");

    var ws = new WebSocket(wsUrl + window.location.host + "/spring-mvc/chat/${userName}");
       
    console.log("ws: " + ws);
        ///// ONMESSAGE
    ws.onmessage = function(event) {
        	
        	
    var mySpan = document.getElementById("chat");
  	var text = event.data; //// respone message
   	
    var temp = text.slice(text.indexOf("adminOnPlay=")+12,50);
    checkParam = isNumeric(temp);
	
    console.log("Message Received: " + temp);

    
	if(checkParam){
		  document.getElementById("myvid").currentTime = temp;
		  document.getElementById("myvid").play();
	}else if(isNumeric(text.slice(text.indexOf("adminOnPause=")+13,50))){
	    document.getElementById("myvid").pause();
		}else{
			mySpan.innerHTML+=text+"<br/>";
			//+"<br/>"+checkParam+"<br/>";

		}
    	
    	
    	
      
    };
     
    ws.onerror = function(event){
        console.log("Error ", event)
    } 
    function sendMsg() {
        var msg = document.getElementById("msg").value;
        if(msg)
        {
            ws.send(msg);
        }
        document.getElementById("msg").value="";
    }
    
    
    function isNumeric(str) {
    	  if (typeof str != "string") return false; // we only process strings!  
    	  return !isNaN(str) && !isNaN(parseFloat(str))  
    	  // use type coercion to parse the _entirety_ of the string (`parseFloat` alone does not do this)...
///// ...and ensure strings of whitespace fail
    	}  
</script>

</body>
</html>

