import React, {Component} from 'react';
import axios from 'axios';
import AdminMenu from "../../../AdminMenu";
import AddLanguage from "./AddLanguage";

import '../../../../../style/FilmData.css';

class LanguageList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            languages: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/languages/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({languages: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/languages/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({languages: response.data});
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <AddLanguage/>
                <div className="allLanguage" id="content">
                    <h1>Languages</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">Language</th>
                        </tr>
                        {this.state.languages.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <td>{idx + 1}</td>
                                    <td>{d.language}</td>
                                </tr>
                            )
                        })}
                    </table>

                </div>
            </div>
        );
    }
}

export default LanguageList;