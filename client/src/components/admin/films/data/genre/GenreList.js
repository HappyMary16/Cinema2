import React, {Component} from 'react';
import axios from 'axios';
import AdminMenu from "../../../AdminMenu";
import AddGenre from "./AddGenre";

import '../../../../../style/FilmData.css';

class GenreList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            genres: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/genres/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({genres: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/genres/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({genres: response.data});
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <AddGenre/>
                <div className="allGenre" id="content">
                    <h1>Genres</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">Genre</th>
                        </tr>
                        {this.state.genres.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <td>{idx + 1}</td>
                                    <td>{d.genre}</td>
                                </tr>
                            )
                        })}
                    </table>

                </div>
            </div>
        );
    }
}

export default GenreList;