import { over } from "stompjs";
import SockJS from "sockjs-client";

import { API_USER_URL, API_CHAT_URL } from "../../../data/constants";

let stompClient = null;

export async function loadPlayer({ token }) {
    try {
        const response = await fetch(`${API_USER_URL}/player/${token}`);
        const data = await response.json();
        return data;
    } catch (error) {
        return undefined;
    }
}

export async function connect(userData, setUserData, onMessageReceived, onUserJoin) {
    let Sock = new SockJS(`${API_CHAT_URL}/chat`);
    stompClient = over(Sock);
    stompClient.connect({}, () => onConnected(userData, setUserData, onMessageReceived, onUserJoin), onError);
    stompClient.debug = null
}

export async function send(api, chatMessage) {
    if (!stompClient) {
        console.error("WebSocket connection is not established");
        return
    }
    await stompClient.send(api, {}, JSON.stringify(chatMessage));
}

async function onConnected(userData, setUserData, onMessageReceived, onUserJoin) {
    setUserData({ ...userData, "connected": true });
    stompClient.subscribe("/chatroom/public", onMessageReceived);
    if (userData.receiverTeamId !== -1)
        stompClient.subscribe(`/chatroom/team/${userData.receiverTeamId}`, onMessageReceived);
    onUserJoin();
}

function onError(error) {
    console.log("error", error);
}