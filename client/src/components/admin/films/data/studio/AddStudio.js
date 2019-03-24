import React, {Component} from 'react';
import axios from 'axios';

class AddStudio extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            studio: ''
        }
    }

    studioChangeHandler = (name) => {
        this.setState({studio: name})
    };

    addStudioHandler = () => {
        let studio = {
            studio: this.state.studio
        };
        const ADD_STUDIO_URL = "http://localhost:8080/studios/add";
        if (this.state.studio.match(/(\w ?)+/)) {
            axios.post(ADD_STUDIO_URL, studio)
                .then(this.props.history.push("/studio_list"));
        }
    };
    render() {
        return (
            <div className="wrapper">
                <div className="studioForm" id="content">
                    <p><input type="text" placeholder="studio"
                              onChange={e => this.studioChangeHandler(e.target.value)}/></p>
                    <p>
                        <button type="submit" onClick={this.addStudioHandler}>Add studio</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AddStudio;