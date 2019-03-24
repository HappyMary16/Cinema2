import React, {Component} from 'react';
import axios from 'axios';

class AddLanguage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            language: ''
        }
    }

    languageChangeHandler = (name) => {
        this.setState({language: name})
    };

    addLanguageHandler = () => {
        let language = {
            language: this.state.language
        };
        const ADD_LANGUAGE_URL = "http://localhost:8080/languages/add";
        if (this.state.language.match(/(\w ?)+/)) {
            axios.post(ADD_LANGUAGE_URL, language)
                .then(this.props.history.push("/language_list"));
        }
    };
    render() {
        return (
            <div className="wrapper">
                <div className="languageForm" id="content">
                    <p><input type="text" placeholder="language"
                              onChange={e => this.languageChangeHandler(e.target.value)}/></p>
                    <p>
                        <button type="submit" onClick={this.addLanguageHandler}>Add language</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AddLanguage;