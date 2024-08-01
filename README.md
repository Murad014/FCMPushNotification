Generate token for web app:
```
import { initializeApp } from "firebase/app";
import { getMessaging, getToken } from "firebase/messaging";

const firebaseConfig = { // this config from firebase. check your firebase copy and past here.
  apiKey: "************************",
  authDomain: "***************",
  projectId: "test-c022cf",
  storageBucket: "*********",
  messagingSenderId: "***********",
  appId: "*********************",
  measurementId: "***********"
};

function sendRequest(){

  Notification.requestPermission().then((permission) => {
  if (permission === "granted") {


  const app = initializeApp(firebaseConfig);
        const messaging = getMessaging(app);
        getToken(messaging, {
          vapidKey:
            "YOUR KEY",
        }).then(async (currentToken) => {
          if (currentToken) {
            // document.getElementById('token').textContent = "Token: " + currentToken;
            // await navigator.clipboard.writeText(currentToken);
            // console.log('Token copied to clipboard');
            console.log("currentToken: ", currentToken);
          } else {
            console.log("Cannot get token");
          }
        });
      } else {
        console.log("Not access");
      }
  });
}

sendRequest();
```
