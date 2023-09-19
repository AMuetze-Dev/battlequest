import { NicknameForm } from "../../features/nickname/index";
import { LobbySelector } from "../../features/lobbyselector";

import style from "./LandingPage.module.css"

export default function Dashboard() {

    return (
        <>
            <h2>LobbySelector</h2>
            <NicknameForm />
            <LobbySelector />
        </>
    )
}