import React, {Component} from "react";

import "../../style/Login.css"
import InputForm from "./InputForm";

class LogIn extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="Login">
                <form>
                    <InputForm
                        labelText="Login"/>
                    <InputForm
                        labelText="Password"/>
                </form>
            </div>
        );
    }
}

export default LogIn;