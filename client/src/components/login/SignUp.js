import React, {Component} from "react";

import "../../style/Login.css"
import InputForm from "./InputForm";

class SingUp extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="Login">
                <form>
                    <InputForm
                        labelText="First name"/>
                    <InputForm
                        labelText="Last name"/>
                    <InputForm
                        labelText="Login"/>
                    <InputForm
                        labelText="Password"/>
                    <InputForm
                        labelText="Phone"/>
                    <InputForm
                        labelText="Email"/>
                </form>
            </div>
        );
    }
}

export default SingUp;