import React, { useRef } from "react";

type SearchType = {
    text: string,
    // onFilterTextChange: (params: any) => {},
    // onEnterSearch: (params: any) => {}
}

const Search = (props: SearchType) => {
    const inputRef = useRef<HTMLInputElement | null>(null);

    return (
        <div className="col-sm-12">
            <div className="input-group">
                <input
                    ref={inputRef}
                    type="search"
                    className="form-control"
                    style={{ width: "55%" }}
                    placeholder="Tìm kiếm..."
                    value={props.text}
                    // onChange={(e) => props.onFilterTextChange(e.target.value)}
                    // onKeyDown={e => (e.code === 'Enter' || e.code === 'NumpadEnter') ? props.onEnterSearch(props.text) : ""}
                />
                <button
                    className="btn btn-success"
                    // onClick={() => props.onEnterSearch(props.text)}
                >
                    <i className="fa fa-search"></i>
                </button>
            </div>
        </div>
    );

}

export default Search;