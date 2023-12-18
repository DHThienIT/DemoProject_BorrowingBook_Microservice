import { Route, Routes } from 'react-router-dom';
import Data from './components/home/Data'

function AllRoute() {
  return (
    <Routes>
      <Route path="/" element={<Data />} />
    </Routes>
  );
}

export default AllRoute;