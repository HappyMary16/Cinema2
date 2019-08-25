import React from "react";

class InputForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            labelText: props.labelText,
        };
    }

    handleInputChange = (event) => {
        this.setState({
            componentValue: event.target.value
        });
    };

    render() {
        return (
            <label>
            {this.state.labelText}:
            <input
                name="login"
                type="textArea"
                value={this.state.componentValue}
                onChange={this.handleInputChange}/>
        </label>
        );
    }
}

export default InputForm;