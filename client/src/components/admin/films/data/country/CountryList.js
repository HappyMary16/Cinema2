import React, {Component} from 'react';
import axios from 'axios';
import AdminMenu from "../../../AdminMenu";
import AddCountry from "./AddCountry";

import '../../../../../style/FilmData.css';

class CountryList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            countries: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/countries/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({countries: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/countries/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({countries: response.data});
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <AddCountry/>
                <div className="allCountry" id="content">
                    <h1>Countries</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">Country</th>
                        </tr>
                        {this.state.countries.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <td>{idx + 1}</td>
                                    <td>{d.country}</td>
                                </tr>
                            )
                        })}
                    </table>

                </div>
            </div>
        );
    }
}

export default CountryList;