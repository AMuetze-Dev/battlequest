import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { useToken } from "../../hooks/useSessionStorage";
import "react-toastify/dist/ReactToastify.css";

import Login from "../Login/Login";
import { Chat } from "../../features/chat/index";
import LandingPage from "../LandingPage/LandingPage";
import NotificationContainer from "../../components/ui/NotificationContainer";

export default function App() {

    const { token, setToken } = useToken();

    return (
        <React.Fragment>
            <BrowserRouter>
                {!token ?
                    <Login setToken={setToken} />
                    :
                    <React.Fragment>
                        <Routes>
                            <Route path="/" element={<LandingPage />} />
                        </Routes>
                        <Chat token={token} />
                    </React.Fragment>
                }
            </BrowserRouter>
            <NotificationContainer />
        </React.Fragment>
    )
}