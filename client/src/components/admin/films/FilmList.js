import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class FilmList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            films: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/films/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({films: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/films/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({films: response.data});
            })
    }

    onClickHandler = () => {
        this.props.history.push("/add_film")
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <div className="allFilms" id="content">
                    <h1>Films</h1>
                    <table>
                        <tr>
                            <th class="title">№</th>
                            <th class="title">Title</th>
                            <th class="title">Min age</th>
                            <th class="title">Duration</th>
                            <th class="title">Language</th>
                            <th class="title">Year</th>
                        </tr>
                        {this.state.films.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <a href={"film_card?id=" + d.id}>
                                        <td>{idx + 1}</td>
                                    </a>
                                    <td>{d.title}</td>
                                    <td>{d.minAge}</td>
                                    <td>{d.duration}</td>
                                    <td>{d.language.language}</td>
                                    <td>{d.year}</td>
                                </tr>
                            )
                        })}
                    </table>

                    <p>
                        <button onClick={this.onClickHandler}>Add film</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default FilmList;