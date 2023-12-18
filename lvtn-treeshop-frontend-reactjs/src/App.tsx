import { Fragment, useEffect, useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import AllRoute from './route';
import Header from './common/Header';
import Footer from './common/Footer';
import Data from './components/home/Data';

function App() {
  const [showGoToTop, setShowGoToTop] = useState(false)

  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY >= 200) {
        setShowGoToTop(true)
      } else {
        setShowGoToTop(false)
      }
    }

    window.addEventListener('scroll', handleScroll)

    return () => {
      window.removeEventListener('scroll', handleScroll)
      console.log('removeEventListener Scroll from Component when Unmounting...')
    };
  }, []);

  const handleGoToTop = () => {
    window.scrollTo({
      top: 0,
      behavior: "smooth"
    });
  };

  return (
    <Fragment>
      <Header />

      <div className="container mt-3">
        <AllRoute />
      </div>

      <Footer />

      {showGoToTop && (
        <button
          className="btn btn-success"
          style={{
            position: 'fixed',
            right: 20,
            bottom: 20,
          }}
          onClick={handleGoToTop}
        >
          Go To Top
        </button>
      )}
    </Fragment>
  );
}

export default App;
