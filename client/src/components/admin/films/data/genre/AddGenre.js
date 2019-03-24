import React, {Component} from 'react';
import axios from 'axios';

class AddGenre extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            genre: ''
        }
    }

    genreChangeHandler = (name) => {
        this.setState({genre: name})
    };

    addGenreHandler = () => {
        let genre = {
            genre: this.state.genre
        };
        const ADD_GENRE_URL = "http://localhost:8080/genres/add";
        if (this.state.genre.match(/(\w ?)+/)) {
            axios.post(ADD_GENRE_URL, genre)
                .then(this.props.history.push("/genre_list"));
        }
    };
    render() {
        return (
            <div className="wrapper">
                <div className="genreForm" id="content">
                    <p><input type="text" placeholder="genre"
                              onChange={e => this.genreChangeHandler(e.target.value)}/></p>
                    <p>
                        <button type="submit" onClick={this.addGenreHandler}>Add genre</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AddGenre;