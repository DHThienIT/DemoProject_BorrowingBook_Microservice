import { memo } from 'react'
import { useLocation } from "react-router-dom";

const Data = () => {
    return (
        <div className="home-section">
            <section className="bg-primary py-5">
            </section>
            <section className="padding-y">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-3">
                        </div>
                        <div className="col-lg-9">
                        </div>

                    </div>
                </div>
            </section>
        </div>
    );
}

export default memo(Data);