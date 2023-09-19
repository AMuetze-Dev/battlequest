import useNicknameForm from "../hooks/useModificateNickname";

import style from "./NicknameForm.module.css"

export default function NicknameForm() {

    const { nickname, setNickname, updateGlobalNickname, getNickname } = useNicknameForm();

    return (
        <section className={style["nickname-form"]}>
            <button onClick={getNickname}>reload</button>
            <input type="text" placeholder="Anzeigename ändern" value={nickname} onChange={setNickname} />
            <button onClick={updateGlobalNickname}> set</button>
        </section >
    )
}