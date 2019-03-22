import React, {Component} from 'react';
import axios from 'axios';
import AdminMenu from "../../../AdminMenu";
import AddStudio from "./AddStudio";

import '../../../../../style/FilmData.css';

class StudioList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            studios: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/studios/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({studios: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/studios/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({studios: response.data});
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <AddStudio/>
                <div className="allStudio" id="content">
                    <h1>Studios</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">Studio</th>
                        </tr>
                        {this.state.studios.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <td>{idx + 1}</td>
                                    <td>{d.studio}</td>
                                </tr>
                            )
                        })}
                    </table>

                </div>
            </div>
        );
    }
}

export default StudioList;